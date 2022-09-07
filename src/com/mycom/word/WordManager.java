package com.mycom.word;

import java.util.Scanner;

public class WordManager {
	Scanner s = new Scanner(System.in); 
	WordCRUD wordCRUD;
	
	/*
	 *** ���ܾ� ������ ***
	 *******************
	 1. ��� �ܾ� ����
	 2. ���غ� �ܾ� ����
	 3. �ܾ� �˻�
	 4. �ܾ� �߰�
	 5. �ܾ� ����
	 6. �ܾ� ����
	 7. ���� ����
	 0. ������
	 *******************
	 => ���ϴ� �޴���?
	 */
	
	WordManager() {
		wordCRUD = new WordCRUD(s);
		
	}
	public int selectMenu() {
		System.out.print("\t *** ���ܾ� ������ ***\n"
				+ "	 *******************\n"
				+ "	 1. ��� �ܾ� ����\n"
				+ "	 2. ���غ� �ܾ� ����\n"
				+ "	 3. �ܾ� �˻�\n"
				+ "	 4. �ܾ� �߰�\n"
				+ "	 5. �ܾ� ����\n"
				+ "	 6. �ܾ� ����\n"
				+ "	 7. ���� ����\n"
				+ "	 0. ������\n"
				+ "	 *******************\n"
				+ "	 => ���ϴ� �޴���?");
		return s.nextInt();
	}
	public void start() {
		while(true) {
			int menu = selectMenu();
			if(menu == 0) break;
			if(menu == 4) {
				//create
				wordCRUD.addWord();
			}
			else if(menu == 1) {
				//list
				wordCRUD.listAll();
			}
		}
	}
}
