#!/usr/bin/env bash

for servise_name in 'tracker-allocations-database' 'tracker-backlog-database' 'tracker-registration-database' 'tracker-timesheets-database'; do
    cf cs cleardb spark ${servise_name}
done