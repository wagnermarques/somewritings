#!/usr/bin/env Rscript
#RLibsDir <- "/home/wagner/wagnerdocri@gmail.com3/fzlbpms/fzlStudio/integrated/R/installed_packages";
cranRepoUrl <- "http://cran.rstudio.com";
#Sys.setenv(
#	   "http_proxy" = "http://wagner:nicolas1*@192.168.0.2:3128/",
#           "ftp_proxy"  = "http://wagner:nicolas1*@192.168.0.2:3128/",
#	   "all_proxy"  = "http://wagner:nicolas1*@192.168.0.2:3128/");

#pkgs <- c('tidyverse');
#pkgs <- c('fs','reprex');
install.packages('devtools' , repo=cranRepoUrl)
install.packages('fs' , repo=cranRepoUrl);
library('fs');
#install.packages(
#               c("webutils","xml2","curl"),
#               dependencies = TRUE,
#               repo = cranRepoUrl);

#install.packages("jsonlite", repos=cranUrl);
#install.packages('curl', repos=cranUrl);

#library(jsonlite);


#seadeV1Dados <- fromJSON("https://api.github.com/repos/hadley/ggplot2/issues");
#seadeV1Dados

