<?php

namespace Ibw\FamilyFinancesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * User
 */
class User
{
    /**
     * @var integer
     */
    private $id;

    /**
     * @var string
     */
    private $name;

    /**
     * @var string
     */
    private $status;

    /**
     * @var string
     */
    private $email;

    /**
     * @var \DateTime
     */
    private $birthday;

    /**
     * @var \Doctrine\Common\Collections\Collection
     */
    private $userIncomes;

    /**
     * @var \Doctrine\Common\Collections\Collection
     */
    private $userExpenses;

    /**
     * @var \Doctrine\Common\Collections\Collection
     */
    private $userFunds;

    /**
     * Constructor
     */
    public function __construct()
    {
        $this->userIncomes = new \Doctrine\Common\Collections\ArrayCollection();
        $this->userExpenses = new \Doctrine\Common\Collections\ArrayCollection();
        $this->userFunds = new \Doctrine\Common\Collections\ArrayCollection();
    }

    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set name
     *
     * @param string $name
     * @return User
     */
    public function setName($name)
    {
        $this->name = $name;

        return $this;
    }

    /**
     * Get name
     *
     * @return string 
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * Set status
     *
     * @param string $status
     * @return User
     */
    public function setStatus($status)
    {
        $this->status = $status;

        return $this;
    }

    /**
     * Get status
     *
     * @return string 
     */
    public function getStatus()
    {
        return $this->status;
    }

    /**
     * Set email
     *
     * @param string $email
     * @return User
     */
    public function setEmail($email)
    {
        $this->email = $email;

        return $this;
    }

    /**
     * Get email
     *
     * @return string 
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * Set birthday
     *
     * @param \DateTime $birthday
     * @return User
     */
    public function setBirthday($birthday)
    {
        $this->birthday = $birthday;

        return $this;
    }

    /**
     * Get birthday
     *
     * @return \DateTime 
     */
    public function getBirthday()
    {
        return $this->birthday;
    }

    /**
     * Add userIncomes
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\UserIncome $userIncomes
     * @return User
     */
    public function addUserIncome(\Ibw\FamilyFinancesBundle\Entity\UserIncome $userIncomes)
    {
        $this->userIncomes[] = $userIncomes;

        return $this;
    }

    /**
     * Remove userIncomes
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\UserIncome $userIncomes
     */
    public function removeUserIncome(\Ibw\FamilyFinancesBundle\Entity\UserIncome $userIncomes)
    {
        $this->userIncomes->removeElement($userIncomes);
    }

    /**
     * Get userIncomes
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getUserIncomes()
    {
        return $this->userIncomes;
    }

    /**
     * Add userExpenses
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\UserExpense $userExpenses
     * @return User
     */
    public function addUserExpense(\Ibw\FamilyFinancesBundle\Entity\UserExpense $userExpenses)
    {
        $this->userExpenses[] = $userExpenses;

        return $this;
    }

    /**
     * Remove userExpenses
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\UserExpense $userExpenses
     */
    public function removeUserExpense(\Ibw\FamilyFinancesBundle\Entity\UserExpense $userExpenses)
    {
        $this->userExpenses->removeElement($userExpenses);
    }

    /**
     * Get userExpenses
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getUserExpenses()
    {
        return $this->userExpenses;
    }

    /**
     * Add userFunds
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\Fund $userFunds
     * @return User
     */
    public function addUserFund(\Ibw\FamilyFinancesBundle\Entity\Fund $userFunds)
    {
        $this->userFunds[] = $userFunds;

        return $this;
    }

    /**
     * Remove userFunds
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\Fund $userFunds
     */
    public function removeUserFund(\Ibw\FamilyFinancesBundle\Entity\Fund $userFunds)
    {
        $this->userFunds->removeElement($userFunds);
    }

    /**
     * Get userFunds
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getUserFunds()
    {
        return $this->userFunds;
    }
    /**
     * @var string
     */
    private $username;

    /**
     * @var string
     */
    private $password;


    /**
     * Set username
     *
     * @param string $username
     * @return User
     */
    public function setUsername($username)
    {
        $this->username = $username;

        return $this;
    }

    /**
     * Get username
     *
     * @return string 
     */
     public function getUsername()
    {
        return $this->username;
    }
 
    /**
     * Set password
     *
     * @param string $password
     * @return User
     */
    public function setPassword($password)
    {
        $this->password = $password;
 
    }
 
    /**
     * Get password
     *
     * @return string 
     */
    public function getPassword()
    {
        return $this->password;
    }
 
    public function getRoles()
    {
        return array('ROLE_ADMIN');
    }
 
    public function getSalt()
    {
        return null;
    }
 
    public function eraseCredentials()
    {
 
    }
 
    public function equals(User $user)
    {
        return $user->getUsername() == $this->getUsername();
    }
	public function __toString()
	{
		return $this->name;
	}	
}
