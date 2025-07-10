resource "aws_db_instance" "foodapp_postgres" {
  allocated_storage       = 20
  engine                  = "postgres"
  engine_version          = "15"
  instance_class          = "db.t3.micro"
  name                    = "foodorderdb"
  username                = var.db_username
  password                = var.db_password
  publicly_accessible     = true
  skip_final_snapshot     = true
  vpc_security_group_ids  = [aws_security_group.foodapp_sg.id]

  tags = {
    Name = "foodapp-postgres-db"
  }
}
