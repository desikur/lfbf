<?php 
$I = new AcceptanceTester($scenario);
$I->wantTo('Search');
$I->amOnPage('/');
$I->click(['xpath'=>".//*[@id='search']"]);
$I->fillField(['xpath'=>".//*[@id='search']"],'MANAGER');
$I->see('Account Manager');