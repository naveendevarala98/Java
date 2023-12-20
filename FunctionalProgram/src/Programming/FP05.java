package Programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudent;

    public Course(String name, String category, int reviewScore, int noOfStudent) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudent = noOfStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudent=" + noOfStudent +
                '}';
    }
}
public class FP05 {

    public static void main(String[] args) {
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Spring","framework",99,1800));
        courseList.add(new Course("Spring boot","framework",96,200));
        courseList.add(new Course("API","microservice",95,200));
        courseList.add(new Course("aws","cloud",94,100));
        courseList.add(new Course("azure","cloud",92,500));
        courseList.add(new Course("microservice","microservice",99,1800));


        //allmatch, nonematch, anymatch

        Predicate<Course> coursePredicateGT95 = course -> course.getReviewScore() > 95;
        Predicate<Course> coursePredicateGT100 = course -> course.getReviewScore() > 100;

        System.out.println(courseList.stream().allMatch(coursePredicateGT95)); //all course should satisfy

        System.out.println(courseList.stream().noneMatch(coursePredicateGT100)); //all course should satisfy

        System.out.println(courseList.stream().anyMatch(coursePredicateGT95)); //any one course match

        //sort
        Comparator<Course> commapreNoOfStud = Comparator.comparing(Course::getNoOfStudent);//increasing order

        System.out.println(
        courseList.stream().sorted(commapreNoOfStud).collect(Collectors.toList()));

        Comparator<Course> comapreNoOfStudDec = Comparator.comparing(Course::getNoOfStudent).reversed();

        System.out.println(
                courseList.stream().sorted(comapreNoOfStudDec).collect(Collectors.toList()));


        //compare student if same then based on review sort
        Comparator<Course> comapreNoOfStudDecandReview = Comparator.comparing(Course::getNoOfStudent)
                .thenComparing(Course::getReviewScore)
                .reversed();

        System.out.println(
                courseList.stream().sorted(comapreNoOfStudDecandReview).collect(Collectors.toList()));

        System.out.println(
                courseList.stream().sorted(comapreNoOfStudDecandReview).
                        limit(2) //top 2 course print
                        .collect(Collectors.toList()));

        System.out.println(
                courseList.stream().sorted(comapreNoOfStudDecandReview).
                        skip(3) //skip top 3 course print
                        .collect(Collectors.toList()));

        System.out.println(
                courseList.stream().sorted(comapreNoOfStudDecandReview).
                        skip(3) //skip top 3 course print
                        .limit(2)
                        .collect(Collectors.toList()));

        System.out.println(
                courseList.stream().max(comapreNoOfStudDecandReview));
        //gets last element from, list based on sorting. note - not max ele in course

        System.out.println(
                courseList.stream().min(comapreNoOfStudDecandReview));

        //findfirst, findany try

        //count total number student which matches reviewcore greate thatn 95 condition
        System.out.println(
                courseList.stream()
                        .filter(coursePredicateGT95)
                        .mapToInt(Course::getNoOfStudent)
                        .sum()
        );

        System.out.println(
                courseList.stream()
                        .filter(coursePredicateGT95)
                        .mapToInt(Course::getNoOfStudent)
                        .average()
        );

        System.out.println(
                courseList.stream()
                        .filter(coursePredicateGT95)
                        .mapToInt(Course::getNoOfStudent)
                        .count()
        );

        System.out.println(
                courseList.stream()
                        .filter(coursePredicateGT95)
                        .mapToInt(Course::getNoOfStudent)
                        .max()
        );

        System.out.println(
                courseList.stream().collect(Collectors.groupingBy(Course::getCategory))
        );

        System.out.println(
                courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );

//        System.out.println(
//                courseList.stream()
//                        .collect(Collectors.groupingBy(Course::getCategory,
//                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
//        );

        System.out.println(
                courseList.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList())))
        );

    }
}
