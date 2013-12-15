<?php

namespace Ibw\FamilyFinancesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Expense
 */
class Expense
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
     * @var \Doctrine\Common\Collections\Collection
     */
    private $userExpense;

    /**
     * Constructor
     */
    public function __construct()
    {
        $this->userExpense = new \Doctrine\Common\Collections\ArrayCollection();
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
     * @return Expense
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
     * Add userExpense
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\UserExpense $userExpense
     * @return Expense
     */
    public function addUserExpense(\Ibw\FamilyFinancesBundle\Entity\UserExpense $userExpense)
    {
        $this->userExpense[] = $userExpense;

        return $this;
    }

    /**
     * Remove userExpense
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\UserExpense $userExpense
     */
    public function removeUserExpense(\Ibw\FamilyFinancesBundle\Entity\UserExpense $userExpense)
    {
        $this->userExpense->removeElement($userExpense);
    }

    /**
     * Get userExpense
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getUserExpense()
    {
        return $this->userExpense;
    }
	public function __toString()
	{
		return $this->name;
	}
}
