#!/bin/bash

check_backup_dir() {
  if ! [ -d backup ]
  then
      mkdir backup
  fi
}

is_empty_file() {
  if [ -e *.cs ]
  then
      cp *.cs ../backup
  else
      echo "$i" is empty
  fi
}

file_backup() {
  today=$(date "+%Y%m%d")
  backup_file_name="backup_$today"

  zip "$backup_file_name".zip backup/*
}

backup_file_del() {
  del_day=30

  sudo find . -type f -name '*.cs' -mtime +$del_day  -exec bash -c "rm -f {}" \; 2> /dev/null
}

transfer_file() {
  scp "$backup_file_name".zip geombong@192.xxx.xx.x:~/backup
}

dir_lists=$(ls -d day*)

check_backup_dir

for i in $dir_lists
do
    cd "$i"
    is_empty_file
    cd ..
done

file_backup
backup_file_del
transfer_file
