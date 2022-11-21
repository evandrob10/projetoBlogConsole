package Application;
import java.time.LocalDateTime;
//importação de pacotes:
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
//Importação de class:
import entites.Post;
import entites.Comment;

public class Main {
	static List <Post> postagens = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		
		int opcao = -1;
		
		do {
			System.out.println("Escolha uma das opções abaixo: ");
			System.out.println("1 - Cadastrar Postagem.");
			System.out.println("2 - Comentar Postagem.");
			System.out.println("0 - Sair.");
			opcao = input.nextInt();
			redirect(opcao);		
		}while(opcao != 0);
	
	}
	
	public static void redirect(int opcao) {
		Scanner input = new Scanner(System.in);	
		switch(opcao) {
			case 1:
				System.out.println("Digite o titulo da postagem: ");
				String title = input.nextLine();
				if(localizarPostagem(title) == null) {
					cadastrarPostagem();
				}else{
					System.out.println("Postagem ja cadastrada!");
				};
				break;
		}
	}
	public static String localizarPostagem(String title) {
		Post postagemEncontrada = new Post();
		for(Post postagem : postagens) {
			if(postagem.getTitle().equalsIgnoreCase(title)) {
				postagemEncontrada = postagem;
			}
		}
		return postagemEncontrada.getTitle();
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
	public static void cadastrarComentarios(Post postagem) {
		Scanner input = new Scanner(System.in);
		for(Post post : postagens) {
			if(postagem.equals(postagem)) {
				System.out.println("Digite o comentario: ");
				String comentario = input.nextLine();
				Comment comment = new Comment(comentario);
				post.addComment(comment);
			}
			
		}
	}
}