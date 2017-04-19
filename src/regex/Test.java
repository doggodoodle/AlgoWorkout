package regex;

/**
 * Created by ritvikmathur on 1/1/17.
 *
 * http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
 */
public class Test {
    public static void main(String[] args) {
        //String EXAMPLE_TEST = "this s";
        String EXAMPLE_TEST = "This is my small example "
                + "string which I'm going to " + "use for pattern matching";
        String pattern = "\\s+";
        System.out.println(EXAMPLE_TEST.matches(pattern));
        System.out.println(EXAMPLE_TEST.split(pattern).length);
        System.out.println(EXAMPLE_TEST.replaceAll("\\s+", ","));

        System.out.println("yes".matches("[Tt]rue|[Yy]es"));

        System.out.println("abcd".matches("[a-zA-Z]{3}"));

        System.out.println("a123a".matches("^[^\\d].*"));

        System.out.println("400".matches("[^0-9]*[123]?[0-9]{1,2}[^0-9]*"));

        System.out.println("732 325 4385".matches("\\d\\d\\d([-,\\s])?\\d\\d\\d([-,\\s])?\\d\\d\\d\\d"));

        System.out.println("127.0.0.1".matches("\\d\\d\\d([-,\\s])?\\d\\d\\d([-,\\s])?\\d\\d\\d\\d"));



    }
}
