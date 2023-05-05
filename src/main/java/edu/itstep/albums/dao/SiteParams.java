package edu.itstep.albums.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="site_params")
public class SiteParams {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	@NotBlank(message = "Name is mandatory")
	@Column(name="web_site_name")
	public String webSiteName;
	
	public SiteParams(String webSiteName) {
		this.webSiteName = webSiteName;
	}
}
