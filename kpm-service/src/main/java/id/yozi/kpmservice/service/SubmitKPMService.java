package id.yozi.kpmservice.service;

import id.yozi.kpmservice.model.User;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import id.yozi.kpmservice.model.dto.SubmissionRequest;
import id.yozi.kpmservice.model.dto.SubmissionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubmitKPMService {

    public ResponseTemplate<List<SubmissionResponse>> getUserSubmissions(User user);

    public ResponseTemplate<SubmissionResponse> getSubmission(Long id);

    public ResponseTemplate<SubmissionResponse> addSubmission(SubmissionRequest submissionRequest);

    public ResponseTemplate<SubmissionResponse> updateSubmission(Long id);

}
