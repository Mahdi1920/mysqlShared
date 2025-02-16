package tn.starter.mysqlShared.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.starter.mysqlShared.mappers.GenericMapper;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class IGenericServiceImpl<T,D> implements IGenericService<T> {
	@Autowired
	protected JpaRepository<D, Long> repository;

	@Autowired
	protected GenericMapper<T, D> mapper;

	@Override
	public T add(T dto) {
		return mapper.toDto(repository.save(mapper.toEntity(dto)));
	}

	@Override
	public T update(T dto) {
		return mapper.toDto(repository.save(mapper.toEntity(dto)));
	}

	@Override
	public T retrieveById(Long id) {
		return mapper.toDto(repository.findById(id)
				.orElseThrow(() ->
						new IllegalArgumentException(new StringBuilder("No ")
								.append(this.getClass().getName())
								.append(" found with this id").toString()
						)));
	}

	@Override
	public List<T> retrieveAll() {
		return mapper.toListDto(repository.findAll()) ;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
