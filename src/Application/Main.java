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
			System.out.println("3 - Ver postagens.");
			System.out.println("0 - Sair.");
			opcao = input.nextInt();
			redirect(opcao);		
		}while(opcao != 0);
	
	}
	
	public static void redirect(int opcao) {
		Scanner input = new Scanner(System.in);	
		String title;
		switch(opcao) {
			case 1:
				System.out.println("Digite o titulo: ");
				title = input.nextLine();
				title = tratamentoDadosEntrada(title);
				if(localizarPostagem(title).getTitle() == null) {
					cadastrarPostagem(title);
				}else{
					System.out.println("Postagem ja cadastrada!");
				};
				break;
			case 2:
				System.out.println("Digite o titulo da postagem que deseja comentar: ");
				title = input.nextLine();
				title = tratamentoDadosEntrada(title);
				Post postagem = localizarPostagem(title);
				if(postagem.getTitle() != null) {
					cadastrarComentarios(postagem);
				}else{
					System.out.println("Postagem não localizada!");
				};
				break;
			case 3:
				if(postagens.size() > 0) {
					System.out.println("Postagens: ");
					for(Post postagens : postagens) {
						System.out.println(String.format("%nTitulo:%n%s%nTexto:%n%s%n", postagens.getTitle(),postagens.getContent()));
						System.out.println("Comentarios: ");
						System.out.println(postagens.todosComentarios());
					}
				}else {
					System.out.println("Não tem postagens cadastradas!");
				}
				break;
		}
	}
	public static String tratamentoDadosEntrada(String dados) {
		dados = dados.trim();
		return dados;
	}
	public static Post localizarPostagem(String title) {
		Post postagemEncontrada = new Post();
		for(Post postagem : postagens) {
			if(postagem.getTitle().equalsIgnoreCase(title)) {
				postagemEncontrada = postagem;
			}
		}
		return postagemEncontrada;
	}
	public static void cadastrarPostagem(String title) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o texto: ");
		String content = input.nextLine();
		
		Post postagem = new Post(title,content);
		postagens.add(postagem);
	}
	public static void cadastrarComentarios(Post postagem) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o comentario: ");
		String comentario = input.nextLine();
		Comment comment = new Comment(comentario);
		postagem.addComment(comment);
	}
}