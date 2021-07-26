package vn.techmaster.jpa.demoonetomany.entity;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class User{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Post> post1 = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void addPost(Post post) {
        post1.add(post);
    }

    public void removePost(Post post) {
        post1.remove(post);
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Comment> post2 = new ArrayList<>();

    public void addComment(Comment comment) {
        post2.add(comment);
    }

    public void removeComment(Comment comment) {
        post2.remove(comment);
    }

	public Object getPost() {
		return null;
	}

	public IntPredicate getComment() {
		return null;
	}
}