variable "resource_group_name" {
  type        = string
  description = "Resoure group name"
}

variable "resource_group_location" {
  type        = string
  description = "Resource group location"
}

variable "app_service_plan_name" {
  type        = string
  description = "App service plan name"
}

variable "app_service_name" {
  type    = string
  default = "App service name"
}

variable "sql_server_name" {
  type        = string
  description = "Sql server name"
}

variable "sql_database_name" {
  type        = string
  description = "Sql database name"
}

variable "sql_admin_login" {
  type        = string
  description = "Sql admin"
}

variable "sql_admin_password" {
  type        = string
  description = "Sql admin pasword"
}

variable "firewall_rule_name" {
  type        = string
  description = "Firewall rule name"
}

variable "repo_URL" {
  type        = string
  description = "Github repo URL"
}