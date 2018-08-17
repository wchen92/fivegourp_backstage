package com.jk.uitl.wyc;

import java.util.List;

import com.jk.model.Dianji;
import com.jk.service.wychao.IWychaoService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;










public class CreateExcel implements Runnable {
	@Autowired
	private IWychaoService WychaoServiceL;

	private SXSSFWorkbook workbook;
	
	private Dianji dianji;

	@Override
	public void run() {
		excel();
	}

	private void excel() {
			System.out.println(Thread.currentThread().getName());
			synchronized (workbook) {
			List<Dianji> userList = WychaoServiceL.getProductList(dianji);
			System.out.println(Thread.currentThread().getName());
			if (userList.size() > 0) {
				Sheet sheet = workbook.createSheet("sheet"+Thread.currentThread().getId());
				Row row = sheet.createRow(0);  
				Cell cell = row.createCell(0);  
				cell.setCellValue("dianjiid");
				cell = row.createCell(1);  
				cell.setCellValue("kechengid");
				cell = row.createCell(2);  
				cell.setCellValue("kechengdianjiliang");

				int size = userList.size();
				for (int j = 0; j < size; j++) {
					Dianji pr = userList.get(j);
					row = sheet.createRow(j+1);
					row.createCell(0).setCellValue(pr.getDianjiid());
					row.createCell(1).setCellValue(pr.getKechengid());
					row.createCell(2).setCellValue(pr.getKechengdianjiliang());

					
					
				}
			}
		}
	}

	public CreateExcel() {
	}

	public CreateExcel(IWychaoService WychaoServiceL, SXSSFWorkbook workbook, Dianji dianji) {
		super();
		this.WychaoServiceL = WychaoServiceL;
		this.workbook = workbook;
		this.dianji = dianji;
	}
	
}
