package com.jk.uitl.wyc;

import com.jk.model.GuangGaoBiao;
import com.jk.service.wychao.IWychaoService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class GuanggaoiExcel implements Runnable {
	@Autowired
	private IWychaoService WychaoServiceL;

	private SXSSFWorkbook xxbook;

	private GuangGaoBiao guangGaoBiao;

	@Override
	public void run() {
		excel();
	}

	private void excel() {
			System.out.println(Thread.currentThread().getName());
			synchronized (xxbook) {

			List<GuangGaoBiao> userList = WychaoServiceL.getguangGaoBiaoList(guangGaoBiao);
			System.out.println(Thread.currentThread().getName());
			if (userList.size() > 0) {
				Sheet sheet = xxbook.createSheet("sheet"+Thread.currentThread().getId());
				Row row = sheet.createRow(0);
				Cell cell = row.createCell(0);
				cell.setCellValue("guanggaoid");
				cell = row.createCell(1);
				cell.setCellValue("money");
				cell = row.createCell(2);
				cell.setCellValue("guanggaoname");
				cell = row.createCell(3);
				cell.setCellValue("guanggaodate");
				cell = row.createCell(4);
				cell.setCellValue("zhanshistatus");
				cell = row.createCell(5);
				cell.setCellValue("chuliren");
				cell = row.createCell(6);
				cell.setCellValue("guanggaophoto");
				int size = userList.size();
				for (int j = 0; j < size; j++) {
					GuangGaoBiao pr = userList.get(j);
					row = sheet.createRow(j+1);
					row.createCell(0).setCellValue(pr.getGuanggaoid());
					row.createCell(1).setCellValue(pr.getMoney());
					row.createCell(2).setCellValue(pr.getGuanggaoname());
					row.createCell(3).setCellValue(pr.getGuanggaodate());
					row.createCell(4).setCellValue(pr.getZhanshistatus());
					row.createCell(5).setCellValue(pr.getChuliren());
					row.createCell(6).setCellValue(pr.getGuanggaophoto());


				}
			}
		}
	}

	public GuanggaoiExcel() {

	}

	public GuanggaoiExcel(IWychaoService WychaoServiceL, SXSSFWorkbook xxbook, GuangGaoBiao guangGaoBiao) {
		super();
		this.WychaoServiceL = WychaoServiceL;
		this.xxbook = xxbook;
		this.guangGaoBiao = guangGaoBiao;
	}

}
