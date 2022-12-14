package entites;
//importação de pacotes:
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private LocalDateTime moment = LocalDateTime.now();
	private String title;
	private String content;
	private Integer likes = 0;

	private List<Comment> comments = new ArrayList<>();
	
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
			comentarios += String.format("%n%s%n----------------%n",comentario.toString());
		}
		return comentarios;
	}

	@Override
	public String toString() {
		return "Post [moment=" + moment + ", title=" + title + ", content=" + content + ", likes=" + likes
				+ ", comments=" + comments + "]";
	}
}
