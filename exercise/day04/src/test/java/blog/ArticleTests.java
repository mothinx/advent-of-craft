package blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArticleTests {

    private Article article;

    private Comment aComment;

    @BeforeEach
    void setUp() {
        article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
        aComment = new Comment(
                "Amazing article !!!",
                "Pablo Escobar",
                LocalDate.now()
        );
    }

    @Test
    void it_should_be_able_to_comment() throws CommentAlreadyExistException {
        article.comment(aComment);

        assertThat(article.getComments())
                .hasSize(1);
    }

    @Test
    void it_should_provide_the_comments() throws CommentAlreadyExistException {
        article.comment(aComment);

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.equals(aComment));
    }

    @Test
    void it_should_forbid_to_add_the_same_comment() throws CommentAlreadyExistException {
        article.comment(aComment);

        assertThatThrownBy(() -> {
            article.comment(aComment);
        }).isInstanceOf(CommentAlreadyExistException.class);
    }
}