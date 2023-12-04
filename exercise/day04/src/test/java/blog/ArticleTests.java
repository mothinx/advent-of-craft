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

        article.addComment(new Comment("Amazing article !!!", "Pablo Escobar", LocalDate.now()));

        assertThat(article.getComments())
                .hasSize(1);
    }

    @Test
    void it_should_add_a_comment_with_the_given_text() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );

        var text = "Amazing article !!!";
        LocalDate now = LocalDate.now();
        article.addComment(new Comment(text, "Pablo Escobar", now));

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.text().equals(text));
    }

    @Test
    void it_should_add_a_comment_with_the_given_author() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );

        var author = "Pablo Escobar";
        article.addComment(new Comment("Amazing article !!!", author, LocalDate.now()));

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.author().equals(author));
    }

    @Test
    void it_should_add_a_comment_with_the_date_of_the_day() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );

        article.addComment(new Comment("Amazing article !!!", "Pablo Escobar", LocalDate.now()));

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.creationDate().equals(LocalDate.now()));
    }

    @Test
    void it_should_throw_an_exception_when_adding_existing_comment() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
        article.addComment(new Comment("Amazing article !!!", "Pablo Escobar", LocalDate.now()));

        assertThatThrownBy(() -> {
            article.addComment(new Comment("Amazing article !!!", "Pablo Escobar", LocalDate.now()));
        }).isInstanceOf(CommentAlreadyExistException.class);
    }
}
