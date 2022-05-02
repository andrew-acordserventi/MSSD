<?php

// must be 7 sub variables - adding or removing entries may break code later (?)
define('TAX_RATES',
  array(
    'Single' => array(
      'Rates' => array(10,12,22,24,32,35,37),
      'Ranges' => array(0,9700,39475,84200,160725,204100,510300),
      'MinTax' => array(0, 970,4543,14382,32748,46628,153798)
      ),
    'Married_Jointly' => array(
      'Rates' => array(10,12,22,24,32,35,37),
      'Ranges' => array(0,19400,78950,168400,321450,408200,612350),
      'MinTax' => array(0, 1940,9086,28765,65497,93257,164709)
      ),
    'Married_Separately' => array(
      'Rates' => array(10,12,22,24,32,35,37),
      'Ranges' => array(0,9700,39475,84200,160725,204100,306175),
      'MinTax' => array(0, 970,4543,14382.50,32748.50,46628.50,82354.75)
      ),
    'Head_Household' => array(
      'Rates' => array(10,12,22,24,32,35,37),
      'Ranges' => array(0,13850,52850,84200,160700,204100,510300),
      'MinTax' => array(0, 1385,6065,12962,31322,45210,152380)
      )
    )
);

// Fill in the code for the following function

// takes an taxable income and marital status, and calculates the tax owed
function incomeTax($taxableIncome, $status) {

    $incTax = 0.0;
    $statusArray = 0;

    // checks for negative number
    if($taxableIncome < 0) {
      return "Must be greater than 0!";
    }

    // checks status
    if($status == 'single') {
      $statusArray = 'Single';
    }
    else if($status == 'marriedJ') {
      $statusArray = 'Married_Jointly';
    }
    else if($status == 'marriedS') {
      $statusArray = 'Married_Separately';
    }
    else if($status == 'head') {
      $statusArray = 'Head_Household';
    }

    // loops through all the possible values held in the array (7 by default); starts at max value
    // checking through the arrays to see where the taxable income falls in range
    for ($index = (count(TAX_RATES[$statusArray]['Ranges'])-1); $index >= 0; $index--) {

      // starts at the maximum value and checks if the taxable income meets criteria
      if($taxableIncome >= TAX_RATES[$statusArray]['Ranges'][$index]) {

        // if taxable income falls within the range, apply long, boring tax rate formula to get the tax ( minTax + ((taxableIncome - taxBracketMin) * (taxRate/100)) )
        $incTax = TAX_RATES[$statusArray]['MinTax'][$index] + (($taxableIncome - TAX_RATES[$statusArray]['Ranges'][$index]) * ((TAX_RATES[$statusArray]['Rates'][$index])/100));
        
        // since we found out tax bracket, we can exit the for loop
        break;
      }
    }

    $incTax = "$".number_format($incTax, 2, ".", ",");

    return $incTax;
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HW4 Part2 - Acord-Serventi</title>

  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

  <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">

    <h3>Income Tax Calculator</h3>

    <form class="form-horizontal" method="post">

      <div class="form-group">
        <label class="control-label col-sm-2">Enter Net Income:</label>
        <div class="col-sm-10">
          <input type="number"  step="any" name="netIncome" placeholder="Taxable  Income" required autofocus>
        </div>
      </div>
      <div class="form-group"> 
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">Submit</button>
        </div>
      </div>
    </form>


    <?php

        // Fill in the rest of the PHP code for form submission results

        // gets form data from the POST HTML input box, then calls methods to calculate tax owed, then prints it all out in a table
        if(isset($_POST['netIncome'])) {
          $income = $_POST['netIncome'];

          // calls and stores the various variables
          $single = incomeTax($income, 'single');
          $marriedJ = incomeTax($income, 'marriedJ');
          $marriedS = incomeTax($income, 'marriedS');
          $head = incomeTax($income, 'head');

          // formats income - note that this can't come earlier, since this turns the number into a string
          $income = number_format($income, 2, ".", ",");

          echo "With a net taxable income of $".$income;

          // prints out the table of data
          echo "<table class='table' style='tableStyle.css'>
                  <tr>
                    <th>Status</th>
                    <th>Tax</th>
                  </tr>
                  <tr>
                    <td>Single</td>
                    <td>$single</td>
                  </tr>
                  <tr>
                    <td>Married Filing Jointly</td>
                    <td>$marriedJ</td>
                  </tr>
                  <tr>
                    <td>Married Filing Single</td>
                    <td>$marriedS</td>
                  </tr>
                  <tr>
                    <td>Head of Household</td>
                    <td>$head</td>
                  </tr>
                </table>
                  ";
        }
    ?>

  
    <h3>2019 Tax Tables</h3>

    <?php

      // calls function to print the tables
      printTables();

      // helper function for a for loop inside the HTML script; prints middle table data
      function printRows($key) {
        $data = TAX_RATES;
        $stringToAdd = "";

        // loops through the data set. Starts at 1 (since 0 is taken care of hard coding). Does not do the final entry (since final entry is hard coded)
        for ($i = 1; $i < count($data['Single']['Rates'])-2; $i++) {

          // adds HTML table data in the correct format, based on which entry the loop is on. 
          $stringToAdd .= 
          "<tr>
            <td>$".number_format($data[$key]['Ranges'][$i], 2, ".", ",")." - ".number_format($data[$key]['Ranges'][($i+1)], 2, ".", ",")."</td>
            <td>$".number_format($data[$key]['MinTax'][$i], 2, ".", ",")." plus ".number_format($data[$key]['Rates'][$i], 0, ".", ",")."% of the amount over $".number_format($data[$key]['Ranges'][$i], 2, ".", ",")."</td>
          </tr>";
        } // I know the formulas in the <td> are long, but I wanted to keep the <td> to one line so you know what is going inside the <td>

        // returns the entire string to add to the table
        return $stringToAdd;

        // side note, the formatting was disgustingly complex and hard to read - I know
      }

      // prints the data tables; first and last are hardcoded; middle tables generated by helper function printRows
      function printTables() {
        // Fill in the code for Tax Tables display
        $data = TAX_RATES;

        // creates a table in HTML to print out the tax tables; hard coded first and last entry since they are different.
        // Calls printRows to print the data in between first and last entries
        foreach ($data as $key => $value) {
          echo "<div>$key</div>
                  <table class='table' border ='2px' style='tableStyle.css'>
                    <tr>
                      <td><b>Taxable Income</b></td>
                      <td><b>Status</b></td>
                    </tr>
                    <tr>
                      <td>$".number_format($data[$key]['Ranges'][0], 2, ".", ",")." - ".number_format($data[$key]['Ranges'][1], 2, ".", ",")."</td>
                      <td>10%</td>
                    </tr>".
                    printRows($key).
                    "<tr>
                      <td>$".number_format($data[$key]['Ranges'][(count($data[$key]['Ranges'])-1)], 2, ".", ",")."+</td>
                      <td>$".number_format($data[$key]['MinTax'][(count($data[$key]['Ranges'])-1)], 2, ".", ",")." plus ".number_format($data[$key]['Rates'][(count($data[$key]['Ranges'])-1)], 0, ".", ",")."% of the amount over $".number_format($data[$key]['Ranges'][(count($data[$key]['Ranges'])-1)], 2, ".", ",")."</td>
                    </tr>
                  </table>"; // end of the echo statement; 
                            // I know the formulas in the <td> are long, but I wanted to keep the <td> to one line so you know what is going inside the <td>
        }
      }
    ?>

         
</div>
</body>
</html>