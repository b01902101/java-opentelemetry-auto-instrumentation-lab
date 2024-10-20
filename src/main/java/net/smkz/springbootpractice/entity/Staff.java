package net.smkz.springbootpractice.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "staff")
@Data
public class Staff implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;
	
	@Column(name = "email", length = 45)
	private String email;
	
	@Column(name = "phone", length = 45)
	private String phone;
	
	@Column(name = "password", length = 45)
	private String password;
	
	@Column(name = "position", length = 45)
	private String position;
}
