package vn.techmaster.jpa.demoonetomany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.jpa.demoonetomany.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{} 
