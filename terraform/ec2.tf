resource "aws_instance" "foodapp_ec2" {
  ami                    = "ami-0c55b159cbfafe1f0"
  instance_type          = var.instance_type
  key_name               = "foodapp-ec2-key"
  vpc_security_group_ids = [aws_security_group.foodapp_sg.id]

  user_data = <<-EOF
              #!/bin/bash
              apt update -y
              apt install docker.io -y
              systemctl start docker
              docker run -d -p 8181:8181 aryanthodupunuri/food-ordering-system:latest
              EOF

  tags = {
    Name = "foodapp-backend-instance"
  }
}
