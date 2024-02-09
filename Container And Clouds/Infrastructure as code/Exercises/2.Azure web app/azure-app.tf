terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "=3.91.0"
    }
  }
}

provider "azurerm" {
  skip_provider_registration = true
  features {}
}

resource "random_integer" "ri" {
  min = 10000
  max = 99999
}

resource "azurerm_resource_group" "azure_app_mitko" {
  name     = "ContactBookRG${random_integer.ri.result}"
  location = "West Europe"
}

resource "azurerm_service_plan" "azure_app_mitko" {
  name                = "contakt-book-${random_integer.ri.result}"
  location            = azurerm_resource_group.azure_app_mitko.location
  resource_group_name = azurerm_resource_group.azure_app_mitko.name
  os_type             = "Linux"
  sku_name            = "F1"
}

resource "azurerm_linux_web_app" "linux_web_app" {
  name                = "contakt-book-${random_integer.ri.result}"
  resource_group_name = azurerm_resource_group.azure_app_mitko.name
  service_plan_id     = azurerm_service_plan.azure_app_mitko.id
  location            = azurerm_resource_group.azure_app_mitko.location

  site_config {
    application_stack {
      node_version = "16-lts"
    }
    always_on = false
  }
}

resource "azurerm_app_service_source_control" "github" {
  app_id                 = azurerm_linux_web_app.linux_web_app.id
  repo_url               = "https://github.com/nakov/ContactBook"
  branch                 = "main"
  use_manual_integration = true
}