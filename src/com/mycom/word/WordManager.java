package com.mycom.word;

import java.util.Scanner;

public class WordManager {
	Scanner s = new Scanner(System.in); 
	WordCRUD wordCRUD;
	
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
		
		wordCRUD.loadFile();
		while(true) {
			int menu = selectMenu();
			if(menu == 0) {
				System.out.println("\t*** �̿����ּż� �����մϴ�. ***");
				break;
			}
			else if(menu == 1) {
				//list
				wordCRUD.listAll();
			}
			else if(menu == 2) {
				wordCRUD.searchLevel();
			}
			else if(menu == 3) {
				wordCRUD.searchWord();
			}
			else if(menu == 4) {
				//create
				wordCRUD.addWord();
			}
			else if(menu == 5) {
				//update
				wordCRUD.updateItem();
			}
			else if(menu == 6) {
				//delete
				wordCRUD.deleteItem();
			}
			else if(menu == 7) {
				wordCRUD.saveFile();
			}
			
		}
	}
}
