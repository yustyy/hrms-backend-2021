package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrms.hrms.HrmsApplication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@OneToOne(optional = true)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Length(max = 300)
	@Column(name = "cover_letter")
	private String coverLetter;
	

	@ManyToMany
	private List<EducationDetail> educationDetails;
	

	@ManyToMany
	private List<JobExperience> jobExperiences;
	
	
	@ManyToMany
	private List<LanguageDetail> languageDetails;
	

	@ManyToMany
	private List<Image> profileImages;

	
	@Column(name = "github_link")
	private String githubLink;
	
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	
	@ManyToMany
	private List<Technology> technologies;
	

	
}
