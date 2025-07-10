output "ec2_public_ip" {
  description = "Public IP of EC2 instance"
  value       = aws_instance.foodapp_ec2.public_ip
}

output "rds_endpoint" {
  description = "PostgreSQL RDS Endpoint"
  value       = aws_db_instance.foodapp_postgres.endpoint
}
