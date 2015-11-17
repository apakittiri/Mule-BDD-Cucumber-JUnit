Feature: File connector reads a file from a particular location and log the file content in the console

	Scenario Outline: Send file content to logger component
  	Given The scenario with "<SCENARIO_ID>" and scenario description "<SCENARIO_DESC>"
    When The Source system "<SOURCE_SYS>" sends "<INBOUND_FILE>" to Destination system "<DESTINATION_SYS>"    
  	Then one acknowledge message will come from "<DESTINATION_SYS>" to "<SOURCE_SYS>"
    
    Examples:
      | SCENARIO_ID            		 | SCENARIO_DESC       					| SOURCE_SYS             | INBOUND_FILE     | DESTINATION_SYS |       
      | File_Data_to_Logger1         | Send file data to logger component   | File_source       	 | files/data.csv   | Logger          |
      #| File_Data_to_Logger2         | Send file data to logger component  | File source directory	 | files/data.csv   | Logger          |