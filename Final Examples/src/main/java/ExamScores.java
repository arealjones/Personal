public class ExamScores {

//  public class StatisticsGenerator {
//    private Integer highestScore;
//    private Integer lowestScore;
//    private Double averageScore;
//
//    public StatisticsGenerator() {
//      highestScore = Integer.MIN_VALUE;
//      lowestScore = Integer.MAX_VALUE;
//      averageScore = Double.MIN_VALUE;
//    }
//    public StatisticsGenerator(Integer minScore, Integer maxScore, Double avgScore){
//      highestScore = maxScore;
//      lowestScore = minScore;
//      averageScore = avgScore;
//    }
//    public void computeStatistics (List<Exam> exams) {
//      Double sum = 0.0;
//      if(exams == null) {
//        System.out.println("No exams");
//        return;
//      }
//      for(Exam myExam: exams) {
//        sum += myExam.getTotalPoints();
//        if(myExam.getTotalPoints() > highestScore)
//          highestScore = myExam.getTotalPoints();
//        if(myExam.getTotalPoints() < lowestScore)
//          lowestScore = myExam.getTotalPoints();
//      }
//      averageScore = sum/exams.size();
//      System.out.println("The highest score on the given batch of exams is:" + highestScore);
//      System.out.println("The lowest score on the given batch of exams is:" + lowestScore);
//      System.out.println("The average score on the given batch of exams is:" + averageScore);
//    }
//  }
}
