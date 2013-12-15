<?php

namespace Ibw\FamilyFinancesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Fund
 */
class Fund
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
     * @var boolean
     */
    private $is_periodic;

    /**
     * @var integer
     */
    private $period;

    /**
     * @var \DateTime
     */
    private $created_at;

    /**
     * @var integer
     */
    private $period_limit;

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
    private $users;

    /**
     * Constructor
     */
    public function __construct()
    {
        $this->userIncomes = new \Doctrine\Common\Collections\ArrayCollection();
        $this->userExpenses = new \Doctrine\Common\Collections\ArrayCollection();
        $this->users = new \Doctrine\Common\Collections\ArrayCollection();
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
     * @return Fund
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
     * Set is_periodic
     *
     * @param boolean $isPeriodic
     * @return Fund
     */
    public function setIsPeriodic($isPeriodic)
    {
        $this->is_periodic = $isPeriodic;

        return $this;
    }

    /**
     * Get is_periodic
     *
     * @return boolean 
     */
    public function getIsPeriodic()
    {
        return $this->is_periodic;
    }

    /**
     * Set period
     *
     * @param integer $period
     * @return Fund
     */
    public function setPeriod($period)
    {
        $this->period = $period;

        return $this;
    }

    /**
     * Get period
     *
     * @return integer 
     */
    public function getPeriod()
    {
        return $this->period;
    }

    /**
     * Set created_at
     *
     * @param \DateTime $createdAt
     * @return Fund
     */
    public function setCreatedAt($createdAt)
    {
        $this->created_at = $createdAt;

        return $this;
    }

    /**
     * Get created_at
     *
     * @return \DateTime 
     */
    public function getCreatedAt()
    {
        return $this->created_at;
    }

    /**
     * Set period_limit
     *
     * @param integer $periodLimit
     * @return Fund
     */
    public function setPeriodLimit($periodLimit)
    {
        $this->period_limit = $periodLimit;

        return $this;
    }

    /**
     * Get period_limit
     *
     * @return integer 
     */
    public function getPeriodLimit()
    {
        return $this->period_limit;
    }

    /**
     * Add userIncomes
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\UserIncome $userIncomes
     * @return Fund
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
     * @return Fund
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
     * Add users
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\User $users
     * @return Fund
     */
    public function addUser(\Ibw\FamilyFinancesBundle\Entity\User $users)
    {
        $this->users[] = $users;

        return $this;
    }

    /**
     * Remove users
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\User $users
     */
    public function removeUser(\Ibw\FamilyFinancesBundle\Entity\User $users)
    {
        $this->users->removeElement($users);
    }

    /**
     * Get users
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getUsers()
    {
        return $this->users;
    }
	public function __toString()
	{
		return $this->name;
	}
}
