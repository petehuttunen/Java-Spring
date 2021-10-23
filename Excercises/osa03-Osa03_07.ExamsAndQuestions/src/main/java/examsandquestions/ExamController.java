package examsandquestions;

import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamController {

    @Autowired
    private ExamRepository examRepository;
    
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/exams")
    public String listExams(Model model) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("examDate").descending());
        model.addAttribute("exams", examRepository.findAll(pageable));
        return "exams";
    }

    @GetMapping("/exams/{id}")
    public String viewExam(Model model, @PathVariable Long id) {
        model.addAttribute("exam", examRepository.getOne(id));
        model.addAttribute("questions", questionRepository.findAll());
        
        return "exam";
    }

    @PostMapping("/exams")
    public String addExam(@RequestParam String subject,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate examDate) {
        
        Exam exam = new Exam();
        exam.setSubject(subject);
        exam.setExamDate(examDate); 
        examRepository.save(exam);

        return "redirect:/exams";
    }

    @PostMapping("/exams/{examId}/questions/{questionId}")
    @Transactional
    public String addQuestionToExam(@PathVariable Long examId, @PathVariable Long questionId) {
        Question question = questionRepository.getOne(questionId);
        Exam exam = examRepository.getOne(examId);
        
        if(!exam.getQuestions().contains(question)){
            exam.getQuestions().add(question);
        }
        
        examRepository.save(exam);
        return "redirect:/exams/" + examId;
    }
}