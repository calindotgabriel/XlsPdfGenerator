// create header map
Row header = sheet.getRow(0);
Map<String, Integer> map = new HashMap();

columns = 0;
Iterator<Cell> cellIterator = header.cellIterator();
while (cellIterator.hasNext()) {
	Cell headCell = cellIterator.next();
	headeCell.setType(STRING);
	String columnName = headCell.getStringCellValue();
	map.put(columnName, columns++);
}

iterator.next(); // move to the values

while (iterator.hasNext()) {
	
}


