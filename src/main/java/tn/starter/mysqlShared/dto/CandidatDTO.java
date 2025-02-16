package tn.starter.mysqlShared.dto;

import lombok.Builder;

@Builder
public record CandidatDTO(long id , String nom , String prenom , Integer nbQuiz) {
}