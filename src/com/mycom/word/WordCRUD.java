package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
	ArrayList<Word> list;
	Scanner s;
	/*
	 * => ���̵�(1,2,3) & �� �ܾ� �Է�: 1 driveway
	 * �� �Է�: ���� ���Է�
	 * �� �ܾ �ܾ��忡 �߰��Ǿ����ϴ�.
	 */
	
	WordCRUD(Scanner s) {
		list = new ArrayList<>();
		this.s = s;
	}
	@Override
	public Object add() {
		System.out.print("=> ���̵�(1,2,3) & �� �ܾ� �Է�: ");
		int level = s.nextInt();
		String word = s.nextLine();
		//1 driveway
		System.out.print("�� �Է�: ");
		String meaning = s.nextLine();
		//���� ���Է�
		return new Word(0, level, word, meaning);
	}
	
	public void addWord() {
		Word one = (Word)add();
		list.add(one);
		System.out.println("�� �ܾ �ܾ��忡 �߰��Ǿ����ϴ�.");
	}
	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectOne(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public void listAll() {
		System.out.println("----------------------------");
		for(int i = 0; i < list.size(); i++) {
			System.out.print((i+1) + " ");
			System.out.println(list.get(i).toString());
		}
		System.out.println("----------------------------");
	}
	
	public ArrayList<Integer> listAll(String keyword) {
		ArrayList<Integer> idlist = new ArrayList<>();
		int j = 0;
		System.out.println("----------------------------");
		for(int i = 0; i < list.size(); i++) {
			String word = list.get(i).getWord();
			if(!word.contains(keyword)) continue;
			System.out.print((j+1) + " ");
			System.out.println(list.get(i).toString());
			idlist.add(i);
			j++;
		}
		System.out.println("----------------------------");
		
		return idlist;
	}
	
	public void updateItem() {
		System.out.print("=> ������ �ܾ� �˻�: ");
		String keyword = s.next();
		ArrayList<Integer> idlist = this.listAll(keyword);
		System.out.print("=> ������ ��ȣ ����: ");
		int id = s.nextInt();
		s.nextLine();
		
		System.out.print("=> �� �Է�: ");
		String meaning = s.nextLine();
		Word word = list.get(idlist.get(id-1));
		word.setMeaning(meaning);
		System.out.println("�ܾ �����Ǿ����ϴ�.");
	}
	public void deleteItem() {
		System.out.print("=> ������ �ܾ� �˻�: ");
		String keyword = s.next();
		ArrayList<Integer> idlist = this.listAll(keyword);
		System.out.print("=> ������ ��ȣ ����: ");
		int id = s.nextInt();
		s.nextLine();
		
		System.out.print("=> ���� �����Ͻðڽ��ϱ�?(Y/N): ");
		String ans = s.next();
		if(ans.equalsIgnoreCase("y")) {
			list.remove(idlist.get(id-1));
			System.out.println("�ܾ �����Ǿ����ϴ�.");
		} else
			System.out.println("��ҵǾ����ϴ�.");		
	}

}
