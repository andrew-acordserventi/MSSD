<?php
// Fill in the code for the following four functions

// takes an income and returns the taxable income amount for single filers
function incomeTaxSingle($taxableIncome) {
    $incTax = 0.0;

    // tax brackets to determine taxes
    if ($taxableIncome > 0 && $taxableIncome < 9700) {
        $incTax = $taxableIncome * 0.1;
        // number formatting (must be done here or number format produces bugs with strings)
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 9700 && $taxableIncome < 39_475) {
        $incTax = 970 + (($taxableIncome - 9700) * 0.12);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 39_475 && $taxableIncome < 84_200) {
        $incTax = 4_543 + (($taxableIncome - 39_475) * 0.22);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 84_200 && $taxableIncome < 160_725) {
        $incTax = 14_382 +(($taxableIncome - 84_200) * 0.24);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 160_725 && $taxableIncome < 204_100) {
        $incTax = 32_748 + (($taxableIncome - 160_725) * 0.32);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 204_100 && $taxableIncome < 510_300) {
        $incTax = 46_628 + (($taxableIncome - 204_100) * 0.35);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 510_300) {
        $incTax = 153_798 + (($taxableIncome - 510_300) * 0.37);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }

    // catchall for negative numbers
    else if ($taxableIncome <= 0) {
        $incTax = "Must be greater than 0!";
    }

    // should never trigger due to form validation
    else {
        $incTax = "Must be a valid number!";
    }

    return $incTax;
}

// takes an income and returns the taxable income amount for married filing jointly filers
function incomeTaxMarriedJointly($taxableIncome) {
    $incTax = 0.0;

    // simplified with no &&
    if ($taxableIncome >= 612_350) {
        $incTax = 164_709 + (($taxableIncome - 612_350) * 0.37);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 408_200) {
        $incTax = 93_257 + (($taxableIncome - 408_200) * 0.35);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 321_450) {
        $incTax = 65_497 + (($taxableIncome - 321_450) * 0.32);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 168_400) {
        $incTax = 28_765 + (($taxableIncome - 168_400) * 0.24);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 78_950) {
        $incTax = 9_086 + (($taxableIncome - 78_950) * 0.22);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 19_400) {
        $incTax = 1_940 + (($taxableIncome - 19_400) * 0.12);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome > 0) {
        $incTax = 0 + ($taxableIncome * 0.10);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }

    // catchall for negative numbers
    else if ($taxableIncome <= 0) {
        $incTax = "Must be greater than 0!";
    }

    // should never trigger due to form validation
    else {
        $incTax = "Must be a valid number!";
    }
    
    return $incTax;
}

// takes an income and returns the taxable income amount for married filing separately filers
function incomeTaxMarriedSeparately($taxableIncome) {
    $incTax = 0.0;

    if ($taxableIncome >= 306_175) {
        $incTax = 82_354.75 + (($taxableIncome - 306_175) * 0.37);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 204_100) {
        $incTax = 46_628.50 + (($taxableIncome - 204_100) * 0.35);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 160_725) {
        $incTax = 32_748.50 + (($taxableIncome - 160_725) * 0.32);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 84_200) {
        $incTax = 14_382.50 + (($taxableIncome - 84_200) * 0.24);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 39_475) {
        $incTax = 4_453 + (($taxableIncome - 39_475) * 0.22);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 9_700) {
        $incTax = 970 + (($taxableIncome - 9_700) * 0.12);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome > 0) {
        $incTax = $taxableIncome * 0.10;
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }

    // catchall for negative numbers
    else if ($taxableIncome <= 0) {
        $incTax = "Must be greater than 0!";
    }

    // should never trigger due to form validation
    else {
        $incTax = "Must be a valid number!";
    }

    return $incTax;
}

// takes an income and returns the taxable income amount for head of household filers
function incomeTaxHeadOfHousehold($taxableIncome) {
    $incTax = 0.0;

    if ($taxableIncome >= 510_300) {
        $incTax = 152_380 + (($taxableIncome - 510_300) * 0.37);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 204_100) {
        $incTax = 45_210 + (($taxableIncome - 204_100) * 0.35);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 160_700) {
        $incTax = 31_322 + (($taxableIncome - 160_700) * 0.32);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 84_200) {
        $incTax = 12_962 + (($taxableIncome - 84_200) * 0.24);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 52_850) {
        $incTax = 6_065 + (($taxableIncome - 52_850) * 0.22);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome >= 13_850) {
        $incTax = 1_385 + (($taxableIncome - 13_850) * 0.12);
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }
    else if ($taxableIncome > 0) {
        $incTax = $taxableIncome * 0.10;
        $incTax = "$".number_format($incTax, 2, ".", ",");
    }

    // catchall for negative numbers
    else if ($taxableIncome <= 0) {
        $incTax = "Must be greater than 0!";
    }

    // should never trigger due to form validation
    else {
        $incTax = "Must be a valid number!";
    }

    return $incTax;
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HW4 Part1 - Andrew Acord-Serventi</title>

  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

  <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <h3>Income Tax Calculator</h3>

    <form class="form-horizontal" method="post">

        
        <div class="form-group">
            <label class="control-label col-sm-2" for="netIncome">Your Net Income:</label>
            <div class="col-sm-10">
            <input type="number" step="any" name="netIncome" placeholder="Taxable  Income" required autofocus>
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
        // script to call results and display functions based on taxable income
        // checks for non-null value in the POST, which is the HTML form part netIncome
        if(isset($_POST['netIncome'])) {
            // income value (easier to work with)
            $income = $_POST['netIncome'];
            echo "Results...";
            echo "<br><br>";
            echo "With a net taxable income of $".number_format($income, 2, ".", ",");
            echo "<br><br>";
            echo "Single: ".incomeTaxSingle($income);
            echo "<br>";
            echo "Married filing jointly: ".incomeTaxMarriedJointly($income);
            echo "<br>";
            echo "Married filing Seperately: ".incomeTaxMarriedSeparately($income);
            echo "<br>";
            echo "Head of Household: ".incomeTaxHeadOfHousehold($income);
            // no need to css - keeping it simple!
            // will implement tables in part 2 where it is required
        }
    ?>

</div>
</body>
</html>