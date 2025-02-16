package tn.starter.mysqlShared.dto;

import java.time.LocalDate;

public record QuizDTO(String id , String titreQuiz , String specialite , LocalDate dateQuiz ) {
}
