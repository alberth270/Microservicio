package com.everis.springboot.app.person.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persons")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(name = "dni")
	private Integer dni;
	@Column(name = "name")
	private String name;
	@Column(name = "last_name")
	private String lasName;
	@Column(name ="num_tarjet")
	private String numTarjet;
	@Column(name="fech_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechNacimiento;

	private static final long serialVersionUID = 7115751435111711538L;
	
}
