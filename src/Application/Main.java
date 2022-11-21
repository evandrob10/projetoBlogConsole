package Application;
import java.time.LocalDateTime;
//importação de pacotes:
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
//Importação de class:
import entites.Post;

public class Main {
	static List <Post> postagens = new ArrayList<>();
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		LocalDateTime moment;
		Integer likes;
	}
	public static void cadastrarPostagem() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o title: ");
		String title = input.nextLine();
		
		System.out.println("Digite da postagem: ");
		String content = input.nextLine();
		
		Post postagem = new Post(title,content);
		postagens.add(postagem);
	}
	public s
}
