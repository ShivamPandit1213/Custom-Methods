List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tableId']/tbody/tr"));

for(int i=1; i<=rows.size(); i++){
    List<WebElement> cols = driver.findElements(By.xpath("//table[@id='tableId']/tbody/tr["+i+"]/td"));
    
    for(int j=1; j<=cols.size(); j++){
        String value = driver.findElement(By.xpath("//table[@id='tableId']/tbody/tr["+i+"]/td["+j+"]")).getText();
        System.out.print(value + " ");
    }
    System.out.println();
}
