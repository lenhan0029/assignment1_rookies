package com.shoes_store.lenhan.services;

import com.shoes_store.lenhan.dto.AuditLogDTO;

public interface AuditService {
	void writeAuditLog(AuditLogDTO dto);
}
