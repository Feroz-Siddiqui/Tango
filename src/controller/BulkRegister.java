package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.event.CellEditorListener;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;

import constant.LoginConstant;
import hibernate.HibernateSessionFactory;
import pojo.Address;
import pojo.Login;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;

/**
 * Servlet implementation class BulkRegister
 */
@WebServlet("/BulkRegister")

@MultipartConfig(location = "C:\\Users\\Feroz\\Desktop\\a", fileSizeThreshold = 512 * 512, maxFileSize = 512 * 512 * 5, maxRequestSize = 512 * 512 * 5 * 5)
public class BulkRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BulkRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			try {
				// Parse the request
				List items = upload.parseRequest(request);
				Iterator iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					if (!item.isFormField()) {
						String fileName = item.getName();
						String root = getServletContext().getRealPath("/");
						File path = new File(root + "/uploads");
						if (!path.exists()) {
							boolean status = path.mkdirs();
						}

						File uploadedFile = new File(path + "/" + fileName);
						System.out.println(uploadedFile.getAbsolutePath());
						item.write(uploadedFile);

						ArrayList<ArrayList<String>> excelData = readExcelData(uploadedFile.getAbsolutePath());
						Session session = HibernateSessionFactory.getSession();
						session.getTransaction().begin();
						for (ArrayList<String> data : excelData) {
							Address add = new Address();
							add.setStreet(data.get(3));
							add.setCity(data.get(4));
							add.setState(data.get(5));
							add.setZipcode(data.get(6));
							Login login = new Login(data.get(0), data.get(1), data.get(2), new Date(), 1, add);

							session.save(login);

						}
						session.getTransaction().commit();
						session.close();

						request.getRequestDispatcher("dashboard/dashboard.jsp").forward(request, response);

					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void printParam(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			System.out.print("param name --> " + paramName + " ");
			String[] paramValues = request.getParameterValues(paramName);
			for (int i = 0; i < paramValues.length; i++) {
				String paramValue = paramValues[i];
				System.out.println("paramValue--> " + paramValue);

			}
		}

	}

	public static ArrayList<ArrayList<String>> readExcelData(String fileName) {
		ArrayList<ArrayList<String>> celllisting = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				if (row.getRowNum() != 0) {
					ArrayList<String> temp = new ArrayList<>();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							temp.add(cell.getNumericCellValue() + "");
							break;
						case Cell.CELL_TYPE_STRING:
							temp.add(cell.getStringCellValue());
							break;
						}
					}
					celllisting.add(temp);

				}
			}

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return celllisting;
	}

}
