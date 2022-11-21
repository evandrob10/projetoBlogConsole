package entites;
//importação de pacotes:
import java.time.LocalDateTime;
import java.util.List;

public class Post {
	private LocalDateTime moment = LocalDateTime.now();
	private String title;
	private String content;
	private Integer likes = 0;

	private List<Comment> comments;
	
	public Post() {
	}
	
	public Post(String title,String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes += likes;
	} 
	
	public void addComment(Comment comentario) {
		comments.add(comentario);
	}
	
	public void removerComment(Comment comentario) {
		comments.remove(comentario);
	}
	
	public String todosComentarios() {
		String comentarios = "";
		for(Comment comentario : comments) {
			comentarios += comentario.toString();
		}
		return comentarios;
	}
	
}
