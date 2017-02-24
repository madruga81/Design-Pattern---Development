package br.com.fiap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Roleta {
	
	private static Random rand = new Random();
	
	private static Aluno alunos[] = null;

	public static void main(String[] args) throws Exception {
		
		Scanner keyboard = new Scanner(System.in);
		
		carregarAlunos();
		
		while (true) {

			System.out.println("<Enter> Para sortear...");
			keyboard.nextLine();

			
			Aluno aluno = sortear();
			if (aluno == null) {
				break;
			} else {
				System.out.println("Aluno [Matricula= " + aluno.getMatricula()
						+ " , Nome=" + aluno.getNome() + "]");				
			}
		}
		
	}
	
	
	public static Aluno sortear() {
		
		Aluno aluno = null;
		
		boolean temSorteio = false;
		
		System.out.println("Sorteando aluno...");
		
		for (Aluno al: alunos) {
			if (! al.isSorteado()) {
				temSorteio = true;
				break;
			}
		}
		
		
		if (temSorteio) {
			
			while (aluno == null) {
				int idx = rand.nextInt(alunos.length);
				if (! alunos[idx].isSorteado() ) {
					aluno = alunos[idx];
					aluno.setSorteado(true);
					break;
				}
			}
			
		} else {
			System.out.println("Todos os alunos foram sorteados !");
			return null;
		}
		
		return aluno;
		
	}
	

	
	
	public static void carregarAlunos() {
		
		List lst = new ArrayList();
		
		String csvFile = "E:/meus_documentos/workspace_keppler/fiap_patterns/roleta/src/resources/alunos.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);
		
				Aluno aluno = new Aluno(country[0], country[1], false);
				
				lst.add(aluno);
				
			}
			
			alunos = (Aluno[])lst.toArray(new Aluno[lst.size()]);
			
			for (Aluno al: alunos) {
				System.out.println("Aluno [Matricula= " + al.getMatricula()
						+ " , Nome=" + al.getNome() + "]");				}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}

}
