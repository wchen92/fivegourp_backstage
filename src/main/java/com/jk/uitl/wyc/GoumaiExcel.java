package com.jk.uitl.wyc;

import com.jk.model.GouMaiBiao;
import com.jk.service.wychao.IWychaoService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class GoumaiExcel implements Runnable {
	@Autowired
	private IWychaoService WychaoServiceL;

	private SXSSFWorkbook xxbook;

	private GouMaiBiao gouMaiBiao;

	@Override
	public void run() {
		excel();
	}

	private void excel() {
			System.out.println(Thread.currentThread().getName());
			synchronized (xxbook) {

			List<GouMaiBiao> userList = WychaoServiceL.getGoumaiList(gouMaiBiao);
			System.out.println(Thread.currentThread().getName());
			if (userList.size() > 0) {
				Sheet sheet = xxbook.createSheet("sheet"+Thread.currentThread().getId());
				Row row = sheet.createRow(0);
				Cell cell = row.createCell(0);
				cell.setCellValue("goumaiid");
				cell = row.createCell(1);
				cell.setCellValue("kechengid");
				cell = row.createCell(2);
				cell.setCellValue("yonghuid");
				cell = row.createCell(3);
				cell.setCellValue("goumaishuliang");
				cell = row.createCell(4);
				cell.setCellValue("goumaidate");
				int size = userList.size();
				for (int j = 0; j < size; j++) {
					GouMaiBiao pr = userList.get(j);
					row = sheet.createRow(j+1);
					row.createCell(0).setCellValue(pr.getGoumaiid());
					row.createCell(1).setCellValue(pr.getKechengid());
					row.createCell(2).setCellValue(pr.getYonghuid());
					row.createCell(3).setCellValue(pr.getGoumaishuliang());
					row.createCell(4).setCellValue(pr.getGoumaidate());




				}
			}
		}
	}

	public GoumaiExcel() {

	}

	public GoumaiExcel(IWychaoService WychaoServiceL, SXSSFWorkbook xxbook, GouMaiBiao gouMaiBiao) {
		super();
		this.WychaoServiceL = WychaoServiceL;
		this.xxbook = xxbook;
		this.gouMaiBiao = gouMaiBiao;
	}

}
