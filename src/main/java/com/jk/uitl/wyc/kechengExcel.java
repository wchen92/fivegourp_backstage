package com.jk.uitl.wyc;

import com.jk.model.KeCheng;
import com.jk.service.wychao.IWychaoService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class kechengExcel implements Runnable {
	@Autowired
	private IWychaoService WychaoServiceL;

	private SXSSFWorkbook workbook;
	
	private KeCheng keCheng;

	@Override
	public void run() {
		excel();
	}

	private void excel() {
			System.out.println(Thread.currentThread().getName());
			synchronized (workbook) {
			List<KeCheng> userList = WychaoServiceL.getkeChengList(keCheng);
			System.out.println(Thread.currentThread().getName());
			if (userList.size() > 0) {
				Sheet sheet = workbook.createSheet("sheet"+Thread.currentThread().getId());
				Row row = sheet.createRow(0);  
				Cell cell = row.createCell(0);  
				cell.setCellValue("kechengid");
				cell = row.createCell(1);  
				cell.setCellValue("kechengname");
				cell = row.createCell(2);  
				cell.setCellValue("kechengprice");
				cell = row.createCell(3);
				cell.setCellValue("keshishu");
				cell = row.createCell(4);
				cell.setCellValue("kechengphoto");
				cell = row.createCell(5);
				cell.setCellValue("kechengjieshao");
				cell = row.createCell(6);
				cell.setCellValue("huiyuanstatus");
				cell = row.createCell(7);
				cell.setCellValue("shenhestatus");

				int size = userList.size();
				for (int j = 0; j < size; j++) {
					KeCheng pr = userList.get(j);
					row = sheet.createRow(j+1);
					row.createCell(0).setCellValue(pr.getKechengid());
					row.createCell(1).setCellValue(pr.getKechengname());
					row.createCell(2).setCellValue(pr.getKechengprice());
					row.createCell(3).setCellValue(pr.getKeshishu());
					row.createCell(4).setCellValue(pr.getKechengphoto());
					row.createCell(5).setCellValue(pr.getKechengjieshao());
					row.createCell(6).setCellValue(pr.getHuiyuanstatus());
					row.createCell(7).setCellValue(pr.getShenhestatus());

					
				}
			}
		}
	}

	public kechengExcel() {
	}

	public kechengExcel(IWychaoService WychaoServiceL, SXSSFWorkbook workbook, KeCheng KeCheng) {
		super();
		this.WychaoServiceL = WychaoServiceL;
		this.workbook = workbook;
		this.keCheng = keCheng;
	}
	
}
