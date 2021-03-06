package me.javaroad.mcloud.blog.service;

import me.javaroad.mcloud.blog.dto.request.LabelRequest;
import me.javaroad.mcloud.blog.entity.Label;
import me.javaroad.mcloud.blog.mapper.LabelMapper;
import me.javaroad.mcloud.blog.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class LabelService {

    private final LabelRepository labelRepository;
    private final LabelMapper labelMapper;

    @Autowired
    public LabelService(LabelMapper labelMapper, LabelRepository labelRepository) {
        this.labelMapper = labelMapper;
        this.labelRepository = labelRepository;
    }

    public Label create(LabelRequest labelRequest) {
        Label label = labelMapper.mapRequestToEntity(labelRequest);
        return labelRepository.save(label);
    }
}
