package blog;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArticleTests {
    @Test
    void it_should_be_able_to_comment() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );

        article.comment(new Comment("Amazing article !!!", "Pablo Escobar", LocalDate.now()));

        assertThat(article.getComments())
                .hasSize(1);
    }

    @Test
    void it_should_provide_the_comments() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );

        var text = "Amazing article !!!";
        var author = "Pablo Escobar";
        LocalDate now = LocalDate.now();
        Comment aComment = new Comment(text, author, now);
        article.comment(aComment);

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.equals(aComment));
    }

    @Test
    void it_should_forbid_to_add_the_same_comment() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
        article.comment(new Comment("Amazing article !!!", "Pablo Escobar", LocalDate.now()));

        assertThatThrownBy(() -> {
            article.comment(new Comment("Amazing article !!!", "Pablo Escobar", LocalDate.now()));
        }).isInstanceOf(CommentAlreadyExistException.class);
    }
}