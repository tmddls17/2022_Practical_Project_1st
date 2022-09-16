package com.mycom.word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
	ArrayList<Word> list;
	Scanner s;
	final String fname = "Dictionary.txt";

	WordCRUD(Scanner s) {
		list = new ArrayList<>();
		this.s = s;
	}

	@Override
	public Object add() {
		System.out.print("=> ���̵�(1,2,3) & �� �ܾ� �Է�: ");
		int level = s.nextInt();
		String word = s.nextLine();
		// 1 driveway
		System.out.print("�� �Է�: ");
		String meaning = s.nextLine();
		// ���� ���Է�
		return new Word(0, level, word, meaning);
	}

	public void addWord() {
		Word one = (Word) add();
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
		for (int i = 0; i < list.size(); i++) {
			System.out.print((i + 1) + " ");
			System.out.println(list.get(i).toString());
		}
		System.out.println("----------------------------");
	}

	public ArrayList<Integer> listAll(String keyword) {
		ArrayList<Integer> idlist = new ArrayList<>();
		int j = 0;
		System.out.println("----------------------------");
		if (keyword.length() > 1) {
			for (int i = 0; i < list.size(); i++) {
				String word = list.get(i).getWord();
				if (!word.contains(keyword))
					continue;
				System.out.print((j + 1) + " ");
				System.out.println(list.get(i).toString());
				idlist.add(i);
				j++;
			}
		}
		else if(keyword.length() == 1) {
			for (int i = 0; i < list.size(); i++) {
				String word = list.get(i).getWord();
				if (!word.substring(0,1).contains(keyword))
					continue;
				System.out.print((j + 1) + " ");
				System.out.println(list.get(i).toString());
				idlist.add(i);
				j++;
			}
		}
		System.out.println("----------------------------");

		return idlist;
	}

	public void listAll(int level) {
		int j = 0;
		System.out.println("----------------------------");
		for (int i = 0; i < list.size(); i++) {
			int ilevel = list.get(i).getLevel();
			if (ilevel != level)
				continue;
			System.out.print((j + 1) + " ");
			System.out.println(list.get(i).toString());
			j++;
		}
		System.out.println("----------------------------");
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
		Word word = list.get(idlist.get(id - 1));
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
		if (ans.equalsIgnoreCase("y")) {
			list.remove((int) idlist.get(id - 1));
			System.out.println("�ܾ �����Ǿ����ϴ�.");
		} else
			System.out.println("��ҵǾ����ϴ�.");
	}

	public void loadFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			String line;
			int count = 0;

			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				String data[] = line.split("\\|");
				int level = Integer.parseInt(data[0]);
				String word = data[1];
				String meaning = data[2];
				list.add(new Word(0, level, word, meaning));
				count++;
			}
			br.close();
			System.out.println("==> " + count + "�� �ε� �Ϸ�!!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveFile() {
		try {
			PrintWriter pr = new PrintWriter(new FileWriter("test.txt"));
			for (Word one : list) {
				pr.write(one.toFileString() + "\n");
			}
			pr.close();
			System.out.println("==> ������ ���� �Ϸ�!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void searchLevel() {
		System.out.print("==> ���ϴ� ������? (1~3): ");
		int level = s.nextInt();
		listAll(level);
	}

	public void searchWord() {
		System.out.print("==> ���ϴ� �ܾ��?: ");
		String keyword = s.next();
		listAll(keyword);
	}

}
