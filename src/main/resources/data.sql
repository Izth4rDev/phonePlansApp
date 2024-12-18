INSERT INTO clients (name, rut, address, birth_date, is_active) VALUES
('Juan Pérez', '12345678-9', 'Av. Principal 123', '1990-05-20', TRUE),
('María González', '98765432-1', 'Calle Secundaria 456', '1985-10-15', TRUE),
('Carlos López', '12312312-3', 'Camino Verde 789', '2000-07-12', FALSE),
('Sofía Ramírez', '45678912-3', 'Pasaje Azul 101', '1995-11-30', TRUE),
('Luis Torres', '78945612-5', 'Calle Amarilla 202', '1988-02-14', TRUE);

INSERT INTO plans (plan_name, price, service_provided, is_active) VALUES
('Plan Básico', 19990, 'Llamadas ilimitadas dentro del país', TRUE),
('Plan Avanzado', 29990, 'Llamadas ilimitadas + Internet 50GB', TRUE),
('Plan Premium', 39990, 'Llamadas ilimitadas + Internet 100GB + Roaming Internacional', FALSE);

INSERT INTO contracts (client_id, plan_id, start_date, end_date) VALUES
 (1, 1, '2023-01-01', '2024-01-01'),
 (1, 2, '2024-01-02', '2025-01-02'),
 (2, 3, '2023-06-01', '2024-06-01'),
 (3, 1, '2023-03-15', '2024-03-15');

